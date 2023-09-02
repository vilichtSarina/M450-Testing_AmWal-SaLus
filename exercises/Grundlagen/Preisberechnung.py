import math
import unittest

def calculatePrice(baseprice, specialprice, extraprice, extras, discount):
    addon_discount = 0
    #result = 0 -> diese Zeile braucht es nicht!

    if ((extras >= 3) and (extras < 5)):
        addon_discount = 10
    else:
        if extras >= 5:
            addon_discount = 15

    #if discount > addon_discount: #This is wrong, there is no relation between addon discount and discount!
       # addon_discount = discount

    result = baseprice * (1 - discount / 100.0) + specialprice + extraprice * (1 - addon_discount / 100.0)

    return result


def test_calculate_price():
    test_ok = True

    # Test case 1: extras < 3
    price = calculatePrice(100.0, 50.0, 20.0, 2, 5.0)
    if not math.isclose(price, 165.0, rel_tol=1e-6):
        print("Test case 1 failed. Expected: 165.0, Actual:", price)
        test_ok = False
    else:
        print("Test case 1 passed.")

    # Test case 3: extras >= 3
    price = calculatePrice(200.0, 75.0, 30.0, 4, 8.0)
    if not math.isclose(price, 286.0, rel_tol=1e-6):
        print("Test case 2 failed Expected: 286.0, Actual:", price)
        test_ok = False
    else:
        print("Test case 2 passed.")

    # Test case 3: extras >= 5
    price = calculatePrice(200.0, 75.0, 30.0, 6, 8.0)
    if not math.isclose(price, 284.5, rel_tol=1e-6):
        print("Test case 3 failed Expected: 284.5, Actual:", price)
        test_ok = False
    else:
        print("Test case 3 passed.")

    if test_ok:
        print("All test cases passed!")
    else:
        print("Some test cases failed.")


# Call calculatePrice with specific arguments
result = calculatePrice(100.0, 50.0, 20.0, 2, 5.0)
print("Result:", result)

#Call the test_calculate_price method
test_calculate_price()
