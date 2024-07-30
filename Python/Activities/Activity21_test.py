import pytest
num1=10
num2=20


def test_addition():
    sum= num1 + num2
    assert sum==30

def test_subtraction():
    sub= num1- num2

    assert sub== -10

def test_multi():
    multi= num1*num2
    assert multi==200

def test_division():
    div=num1/num2
    assert div==2 


