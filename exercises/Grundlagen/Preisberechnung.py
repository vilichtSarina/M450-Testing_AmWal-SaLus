import math

def calculatePrice(baseprice, specialprice, extraprice, extras, discount):
    addon_discount = 0
    result = 0

    if extras >= 3:
        addon_discount = 10
    else:
        if extras >= 5:
            addon_discount = 15

    if discount > addon_discount:
        addon_discount = discount

    result = baseprice * (1 - discount / 100.0) + specialprice + extraprice * (1 - addon_discount / 100.0)

    return result


def test_calculate_price():
    test_ok = True

    # Test case 1: extras < 3, discount < addon_discount
    price = calculatePrice(100.0, 50.0, 20.0, 2, 5.0)
    if not math.isclose(price, 165.0, rel_tol=1e-6):
        print("Test case 1 failed. Expected: 165.0, Actual:", price)
        test_ok = False
    else:
        print("Test case 1 passed.")

    # Test case 2: extras >= 3, discount < addon_discount
    price = calculatePrice(200.0, 75.0, 30.0, 4, 8.0)
    if not math.isclose(price, 275.0, rel_tol=1e-6):
        print("Test case 2 failed. Expected: 275.0, Actual:", price)
        test_ok = False
    else:
        print("Test case 2 passed.")

    # Test case 3: extras >= 5, discount > addon_discount
    price = calculatePrice(150.0, 60.0, 25.0, 6, 20.0)
    if not math.isclose(price, 192.5, rel_tol=1e-6):
        print("Test case 3 failed. Expected: 192.5, Actual:", price)
        test_ok = False
    else:
        print("Test case 3 passed.")

    # Add more test cases if needed

    if test_ok:
        print("All test cases passed!")
    else:
        print("Some test cases failed.")


# Call calculatePrice with specific arguments
result = calculatePrice(250.0, 80.0, 40.0, 7, 12.0)
print("Result:", result)

# Call the test_calculate_price method
test_calculate_price()
