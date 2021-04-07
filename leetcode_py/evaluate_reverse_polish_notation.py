#coding:utf-8   

class Solution(object):
    def evalRPN(self, tokens):

        ops = set(["+", "-", "*", "/"])
        stack = []
        
        for token in tokens:
            print token, stack
            if ops.__contains__(token):
                op1 = stack.pop()
                op2 = stack.pop()
                if token == "-":
                    stack.append(op2 - op1)
                elif token == "*":
                    stack.append(int(op1 * op2))
                elif token == "/":
                    stack.append(int(op2 / op1))
                else:
                    stack.append(op1 + op2)
            else:
                stack.append(float(token))
          
        return int(stack.pop())
                    
                
            

#  ((2 + 1) * 3)
tokens = ["4","13","5","/","+"]

s = Solution()
print s.evalRPN(tokens)
        