myFruits={
    "Apple": 50,
    "Mango": 20,
    "Banana": 10
}

userInput= input("Which fruit you want to buy :").lower()

if (userInput in myFruits):
    print("Yes fruit is availble")
else:
    print("No, this is not available")