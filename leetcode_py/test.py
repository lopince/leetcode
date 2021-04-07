import requests

drop_url='https://km.netease.com/news/list/346'
rsp = rsp = requests.post(drop_url)
print 'Dropped partition drop, url: {}, rsp: {}'.format(drop_url, rsp)