class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = []
        ops = {"+", "-", "*", "/"}

        for token in tokens:
            if token in ops:
                second = stack.pop()
                first = stack.pop()

                if token == "+":
                    result = first + second
                elif token == "-":
                    result = first - second
                elif token == "*":
                    result = first * second
                else:
                    result = int(first / second)
                
                stack.append(result)
            else:
                stack.append(int(token))
        
        return stack.pop()
        