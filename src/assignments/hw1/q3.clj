(ns assignments.hw1.q3
  (:require
   [assignments.hw1.utils :refer :all]
   [tablecloth.api :as tc]
   [fastmath.core :as m]
   [fastmath.stats :as s]))

(question "Question 3")
(sub-question "Q3: Early Course Feedback (20 points)")
(sub-sub "I hope the course is going smoothly for you. Based on the contents in the first two weeks, what do you feel? Are you struggling with any topics? Are the contents interesting and helpful to you? Are you expecting any changes in the class? Your feedback is important and helpful in improving the content quality and course delivery. Please do not hesitate to share.")

(md "Course Feedback:

**Positive Aspects:**
The course has been engaging so far, with several noteworthy strengths. Dr. Nui's presentation style is nice, with well-organized information in PowerPoint slides and smooth talker during lectures. The course content is intriguing, with topics such as Recurrent Neural Networks (RNNs) standing out as particularly fascinating.

**Areas for Improvement:**
While the theoretical aspects are covered, I'd like to see more practical application of concepts. The inclusion of more code-based examples would be beneficial. For instance, implementing neural networks we've discussed (e.g. MLP, RNN, CNN) using PyTorch would help bridge the gap between theory and practice.
     
**Suggestions:**
To address these challenges, it would be helpful to incorporate more coding exercises and demonstrations. Step-by-step guides for implementing key algorithms or models discussed in class would be invaluable. This approach would both solidify our understanding of our topics and improve our ability to apply theoretical knowledge in practical scenarios.

**Challenges:**
Some concepts, particularly RNNs, have proven challenging to fully grasp. Moreover, translating course concepts into code has been difficult. A case in point is my attempt to implement PCA using eigenvectors in this assignment. This endeavor presented significant hurdles, especially when working with eigenvalues. Despite my efforts, I struggled to correctly calculate and apply the eigenvalues, which are crucial for determining the principal components.

**Personal Goals:**
Moving forward, I aim to improve my ability to translate theoretical concepts into working code. Specifically, I plan to continue refining my PCA implementation, and make it work. In addition, I plan to implement K-means clustering--as another unsupervised method--that I feel is possible to implement in terms of a Clojure library for machine learning.

Overall, the class is valuable and engaging. The integration of more hands-on coding examples would enhance the learning experience.")
