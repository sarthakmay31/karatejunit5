@BMI
Feature: Calculates the bmi and return the scale

  Background: 
    * configure headers = read('classpath:headers.js')


  @CalculateBMI @ignore
  Scenario Outline: Calculates bmi with provided user details
    Given url BMIbaseURL
    And path 'imperial'
    And params {"weight":<weight>,"height":<height>}
    When method GET
    Then status 200

    Examples: 
      | weight | height |
      |    200 |     68 |

  @WeightCategory
  Scenario: User weight category based on the calculated BMI
    Given url BMIbaseURL
    And path 'weight-category'
    * def calculate = call read('BMI.feature@CalculateBMI')
    * def bmi = calculate.response.bmi
    And params {"bmi":'#(bmi)'}
    When method GET
    Then status 200
    * print 'Calculated BMI---',bmi
    * print 'Weight Category---',response.weightCategory

 