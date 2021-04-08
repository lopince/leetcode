from queue import Queue


class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

    @staticmethod
    def gen(list):
        n = len(list)

        if n == 0:
            return None

        root = TreeNode(list[0])

        q = Queue(n)
        q.put(root)

        for i in range(1, n, 2):
            cur = q.get()

            if cur != None:
                j = i

                if list[j] != None:
                    l = TreeNode(list[j])
                else:
                    l = None

                j += 1
                if j < n and list[j] != None:
                    r = TreeNode(list[j])
                else:
                    r = None

                cur.left = l
                cur.right = r

                q.put(l)
                q.put(r)

        return root

    def __str__(self):

        ret = []

        q = Queue()
        q.put(self)

        while not q.empty():

            size = q._qsize()
            while size > 0:

                cur = q.get()
                if cur != None:
                    ret.append(cur.val)
                    q.put(cur.left)
                    q.put(cur.right)
                else:
                    ret.append(None)

                size -= 1

        while ret[-1] == None:
            ret.pop()

        return str(ret)


seq = [10, 5, -3, 3, 2, None, 11, 3, -2, None, 1]

root = TreeNode.gen(seq)
print root