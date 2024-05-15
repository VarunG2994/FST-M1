from selenium import webdriver
from selenium.webdriver.common.by import By

with webdriver.Chrome() as driver:

    driver.get("https://v1.training-support.net")

    print(f"Title of the page is {driver.title}")

    driver.find_element(By.ID, "about-link").click()

    print(f"Title of the page is {driver.title}")
    

    driver.quit()