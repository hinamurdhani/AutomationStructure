Feature: searching a word in google

	Scenario: kai pan
		Given google homepage
		When I search in home page
			| normal_search |
		Then it will give proper output

	Scenario: kai pan part 2
		Given google homepage
		When I search in home page
			| sentence_search |
		Then it will give proper output
