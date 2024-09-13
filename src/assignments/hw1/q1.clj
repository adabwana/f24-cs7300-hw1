(ns assignments.hw1.q1
  (:require
   [assignments.hw1.utils :refer :all]
   [tablecloth.api :as tc]))


(question "Question 1")
(sub-question
 "Q1: A Case Analysis (40 Points)")
(sub-sub
 "A data scientist is working on a machine learning project with a dataset that initially contains 10 features. However, the model performance was not satisfying based on initial experiments. To enhance the model's performance, he decided to add 50 more features, thinking that more data points would improve the model's accuracy. However, the opposite occurred: the model's accuracy decreased, the training process became slower, and the results became less reliable and harder to interpret. By looking into the details of the data, the scientist noticed three things:")
(md
 "- ***There were a lot of numerical features that vary significantly regarding values.***
- ***The model was overfitting with too many features.***
- ***The training process took much longer to converge (finish).***")
(sub-sub "Can you help the scientist identify the causes of the failure and propose some solutions?")

(md "The data scientist's challenges stem from several key issues related to the nature of the features, model complexity, and data processing.")

(sub-sub "1. **Problem: Features with significant numerical variation**")
(md
 "***Cause:*** Features that vary significantly in magnitude can negatively impact many machine learning models, especially those that rely on distance metrics (e.g., linear models, SVMs). Some features may dominate others due to their scale, leading to biased results.
  
 ***Solution:*** Apply feature scaling techniques like standardization (z-score normalization) or min-max normalization to ensure all features are on a similar scale. This will allow the model to weigh all features more equally.")


(let [data (tc/dataset {:age [20 30 35 40 50]
                        :income [30000 40000 59000 55000 90000]
                        :credit-score [650 700 750 800 850]
                        :z [-2 -1 0 1 2]})

      normalized-data (apply-to-all-columns data normalize-column)]
  (tc/dataset normalized-data))


(md
 "**I. Normalization (Min-Max Scaling):**")
(md
 "***Purpose:*** Scales features to a fixed range, typically [0, 1].

  ***Mathematics:***
  Where X is the original value, X_min is the minimum value in the feature, and X_max is the maximum value. See `utils/normalize-column` for specifics.

  ***Benefits:***
  
   - Bounds values to a specific range, useful when you need values in a certain range (e.g., for neural network inputs).
   - Preserves zero values and sparsity in sparse data.
   - Helpful when the distribution of data is not Gaussian or the standard deviation is unknown.")

(let [data (tc/dataset {:age [20 30 35 40 50]
                        :income [30000 40000 59000 55000 90000]
                        :credit-score [650 700 750 800 850]
                        :z [-2 -1 0 1 2]}) ; results?

      standardized-data (apply-to-all-columns data standardize-column)]
  (tc/dataset standardized-data))


(md
 "**II. Standardization (Z-score Normalization):**")
(md
 "***Purpose:*** Transforms data to have a mean of 0 and a standard deviation of 1.

***Mathematics:***
Where X is the original value, μ is the mean of the feature, and σ is the standard deviation.

***Benefits:***

- Centers the feature around zero, which can be important for many machine learning algorithms.
- Useful when features have significantly different scales or units.
- Particularly beneficial for algorithms that assume normally distributed data (e.g., linear regression, logistic regression).")


(sub-sub "2. **Problem: Model overfitting due to too many features**")

(md
 "***Cause:*** Adding more features increases the dimensionality of the dataset, which can lead to the curse of dimensionality. The model may become too complex and start to 'memorize' the training data rather than generalizing to new data, leading to overfitting.

 ***Solution:*** Reduce the number of features by applying dimensionality reduction techniques like Principal Component Analysis (PCA) or Feature Selection methods (e.g., Lasso regression, recursive feature elimination). This reduces complexity while keeping the most relevant information.")


(let [data (-> (tc/dataset {:x [1 2 3]
                            :y [10 8 2]
                            :z [6 3 5]})
               dataset->matrix)
      centered-data (center-data data)]
  centered-data)


(comment
  (defn compute-covariance-matrix
    "Computes the covariance matrix of the centered data.
    Parameters:
    - centered-data: Centered Neanderthal matrix"
    [centered-data]
    (mm (trans centered-data) centered-data)))


(let [data (-> (tc/dataset {:x [1 2 3]
                            :y [10 8 2]
                            :z [6 3 5]})
               dataset->matrix)
      centered-data (center-data data)
      cov-matrix (compute-covariance-matrix centered-data)]
  cov-matrix)


(sub-sub "3. **Problem: Slower training process**")

(md
 "***Cause:*** With more features, the computational complexity increases, leading to slower convergence of the model during training. This is especially true for iterative algorithms like gradient descent.

 ***Solution:*** Simplify the model by using fewer features (as mentioned) and apply regularization techniques like L1 (Lasso) or L2 (Ridge) to penalize overly complex models and prevent overfitting. Additionally, try early stopping methods to halt the training when improvement stagnates, preventing wasted computation time.")

(md "**Further Considerations for Model Improvement:**

1. **Cross-validation:** Implement k-fold cross-validation to enhance model performance assessment and mitigate overfitting risks.

2. **Data augmentation:** When feasible, expand the dataset through appropriate augmentation techniques. This approach can help the model better utilize the increased feature space and potentially reduce overfitting.

3. **Model complexity optimization:** Begin with simpler, more interpretable models such as decision trees or linear regression before progressing to more complex architectures. This stepwise approach allows for:
   - Establishing a baseline performance
   - Identifying key features
   - Gradually increasing model complexity as needed
   
   Complex models often require more extensive hyperparameter tuning and computational resources, which may not always yield proportional performance gains.")


