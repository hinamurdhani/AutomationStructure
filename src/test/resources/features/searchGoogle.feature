Feature: searching a word in google

	Scenario: Google scenario1
		Given google homepage
		When I search in home page
			| normal_search |
		Then it will give proper output

	Scenario: Google scenario2
		Given google homepage
		When I search in home page
			| sentence_search |
		Then it will give proper output
