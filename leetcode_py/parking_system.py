class ParkingSystem(object):

    def __init__(self, big, medium, small):
        """
        :type big: int
        :type medium: int
        :type small: int
        """
        self.cap = []
        self.cap.append(big)
        self.cap.append(medium)
        self.cap.append(small)

    def addCar(self, carType):
        """
        :type carType: int
        :rtype: bool
        """
        i = carType - 1
        if self.cap[i] > 0:
            self.cap[i]--
            return True
        else:
            return False
