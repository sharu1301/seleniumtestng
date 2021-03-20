Feature: MyFeature

@Regression
Scenario: Verify selenium webdriver book price
	Given User navigates to url
	When User input text "selenium test" on "Home_Page.Search_TextBox"
	When User clicks on "Home_Page.Submit_Button"
	When User clicks on "Result_Page.Selenium_Book_Link"
	Then User verify value of "Result_Page.Book_Price_Element" is "$49.99"
	Then User closes the browser
