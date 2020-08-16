from Package01.login_page_reusables import *

def test_case_01():
    print('TS_01 : To Verify Facebook URL')
    print('TS_01 : To Verify Facebook URL')
    set_property_chrome_browser()
    wait_implicity()
    browser_maximize()
    get_url()
    close_all_browser()
    print('Facebook URL successfully Verified')

def test_case_02():
    print('TS_02 : To Verify Facebook Login Functionality')
    set_property_chrome_browser()
    wait_implicity()
    browser_maximize()
    get_url()
    enter_email_id()
    enter_password()
    click_login_button()
    close_all_browser()
    print('Facebook Login Functionality is successfully Verified')








