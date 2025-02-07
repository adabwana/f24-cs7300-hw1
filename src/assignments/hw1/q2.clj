(ns assignments.hw1.q2
  (:require
   [assignments.hw1.utils :refer :all]
   [fastmath.core :as m]))


(question "Question 2")
(sub-question
 "Q2: Probability Review (40 Points)")
(sub-sub
 "Suppose a certain disease affects 2% of the population. A test for the disease is 90% accurate for those who have the disease (true positive rate) and 95% accurate for those who do not have the disease (true negative rate). What is the probability that a person who tested positive has the disease?")
(sub-sub
 "Explicitly write down the steps of the calculation. Result without steps shown will receive zero point.")

(md "
This problem is a classic application of Bayes' theorem, which allows us to calculate conditional probabilities. Bayes' theorem is expressed as:
")

(formula "P(A|B) = \\frac{P(B|A) \\cdot P(A)}{P(B)}")

(md "
Where:
- P(A|B) is the probability of event A given that B has occurred
- P(B|A) is the probability of event B given that A has occurred
- P(A) is the probability of event A
- P(B) is the probability of event B

In our context:
- A is the event of having the disease
- B is the event of testing positive

Bayes' theorem allows us to calculate the probability of having the disease given a positive test result, which is not immediately apparent from the given information. This demonstrates the theorem's power in updating probabilities based on new evidence.

Let's break down the solution step by step:")

(let [population 100000        disease-rate 0.02
      true-positive-rate 0.90        true-negative-rate 0.95
        ; Step 1: Calculate the number of people with and without the disease
      with-disease (* population disease-rate)
      without-disease (- population with-disease)
        ; Step 2: Calculate true positives and false positives
      true-positives (* with-disease true-positive-rate)
      false-positives (* without-disease (- 1 true-negative-rate))
        ; Step 3: Calculate total positive tests
      total-positives (+ true-positives false-positives)
        ; Step 4: Calculate the probability
      probability (/ true-positives total-positives)]

  (answer
   (str "Final probability that despite a positive test result, there is only about a "
        (* 100 (m/approx probability 4))
        "% chance that the person actually has the disease.")))

(md
 "This counterintuitive result, known as the base rate fallacy, occurs because the low prevalence of the disease in the population significantly influences the outcome, even with a highly accurate test.")

(md "
### Explanation:

1. We start with a hypothetical population of 100,000 to make our calculations more tangible.

2. Given the disease rate of 2%, we calculate the number of people with and without the disease:
")

(formula "\\text{With disease} = 100,000 \\times 0.02 = 2,000")
(formula "\\text{Without disease} = 100,000 - 2,000 = 98,000")

(md "
3. We then determine the number of true positives (people with the disease who test positive) and false positives (people without the disease who test positive):")

(formula "\\text{True positives} = 2,000 \\times 0.90 = 1,800")
(formula "\\text{False positives} = 98,000 \\times (1 - 0.95) = 4,900")

(md "
4. The total number of positive tests is the sum of true positives and false positives:")

(formula "\\text{Total positives} = 1,800 + 4,900 = 6,700")

(md "
5. Finally, we calculate the probability that a person who tested positive has the disease by dividing the number of true positives by the total number of positive tests:")

(formula "P(\\text{Disease}|\\text{Positive}) = \\frac{\\text{True positives}}{\\text{Total positives}} = \\frac{1,800}{6,700} \\approx 0.2687")

(md "
This approach, reminiscent of Kahneman's 'Linda problem', demonstrates how our intuitions about probability can be misleading. Despite the high accuracy rates of the test, the low prevalence of the disease in the population significantly affects the final probability.

It's worth noting that this calculation assumes independence between test results and disease prevalence, which may not always hold in real-world scenarios. Factors such as test administration, population demographics, and environmental conditions could potentially influence these probabilities.")