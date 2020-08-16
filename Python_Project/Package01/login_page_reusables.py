from selenium import webdriver
from Package01.inputs import *
from Package01.controls import *

def set_property_chrome_browser():
    global driver
    driver = webdriver.Chrome(chromedriver_path)

def wait_implicity():
    driver.implicitly_wait(5)

def browser_maximize():
    driver.maximize_window()

def get_url():
    driver.get(facebook_inputs_url)

def enter_email_id():
    driver.find_element_by_name(facebook_controls_email_textfield).send_keys(facebook_inputs_username)

def enter_password():
    driver.find_element_by_name(facebook_controls_password_textfield).send_keys(facebook_inputs_password)

def click_login_button():
    driver.find_element_by_name(facebook_controls_login_button).click()

def close_all_browser():
    driver.quit()

