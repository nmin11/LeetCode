class TimeMap:

    def __init__(self):
        self.store = {}
        

    def set(self, key: str, value: str, timestamp: int) -> None:
        self.store.setdefault(key, []).append((timestamp, value))
        

    def get(self, key: str, timestamp: int) -> str:
        if key not in self.store:
            return ""
        
        history = self.store[key]
        left = 0
        right = len(history) - 1
        result = ""

        while left <= right:
            mid = (left + right) // 2
            if history[mid][0] <= timestamp:
                result = history[mid][1]
                left = mid + 1
            else:
                right = mid - 1
        
        return result
        


# Your TimeMap object will be instantiated and called as such:
# obj = TimeMap()
# obj.set(key,value,timestamp)
# param_2 = obj.get(key,timestamp)