import json
from datetime import datetime

def printIn(matrix):
    for i in range(len(matrix)):
        print matrix[i]
        
def toPrettyJson(jsonObject):
    return json.dumps(jsonObject, indent=4, sort_keys=True)

def toDateTime(str):
    format = '%Y-%m-%d %H:%M:%S'
    d = datetime.strptime(str, format)
    
    print 'd.year:', d.year
    print 'd.month:', d.month
    print 'd.day:', d.day
    print 'd.hour:', d.hour
    print 'd.min:', d.minute
    print 'd.second:', d.second
    
toDateTime('2021-04-01 11:17:30')