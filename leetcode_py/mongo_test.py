import pymongo
import utils
from bson.objectid import ObjectId


url = "mongodb://dev:dev@192.168.42.163:30000/tagsystem"
client = pymongo.MongoClient(url)
tagsystem = client["tagsystem"]
tags = tagsystem["tags"]
dm_game_role_bind = tagsystem['dm_game_role_bind']

# search
ret = dm_game_role_bind.find({'role_level':{'$gt':15}})
ret2 = dm_game_role_bind.find().sort('role_level', pymongo.ASCENDING)
# for r in ret2:
#     if r.has_key('game_name'):
        # print r['game_name'], ":", r['role_level']

# explain
print utils.toPrettyJson(dm_game_role_bind.find({'role_level':{'$gt':15}}).explain())
    
