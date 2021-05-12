import copy


class Solution(object):
    def gameOfLife(self, board):
        """
        :type board: List[List[int]]
        :rtype: None Do not return anything, modify board in-place instead.
        """
        n = len(board)
        m = len(board[0])

        temp = copy.deepcopy(board)

        for i in range(n):
            for j in range(m):
                alive = self.get_alive(board, i, j)
                print('board[{}][{}]={}, alive={}'.format(
                    i, j, board[i][j], alive))
                if alive == 3:
                    temp[i][j] = 1

                if alive < 2 or alive > 3:
                    temp[i][j] = 0

        return temp

    def get_alive(self, board, y, x):

        alive = 0

        n = len(board)
        m = len(board[0])

        for i in range(y - 1, y + 2):
            for j in range(x - 1, x + 2):
                if 0 <= i and i < n and 0 <= j and j < m:
                    if not (i == y and j == x):
                        if board[i][j] == 1:
                            alive += 1

        return alive


board = [[0, 1, 0], [0, 0, 1], [1, 1, 1], [0, 0, 0]]
# board = [[1, 1], [1, 0]]


s = Solution()
temp = s.gameOfLife(board)

print()
for i in range(len(board)):
    print(board[i], temp[i])
