^:kindly/hide-code
(ns index
  (:require 
   [assignments.hw1.utils :refer [question answer md]]
   [scicloj.kindly.v4.kind :as kind])
  (:import [java.time LocalDate]
           [java.time.format DateTimeFormatter]))

(let [formatter (DateTimeFormatter/ofPattern "M/d/yy")
      current-date (str (.format (LocalDate/now) formatter))]
  (md (str "

### Jaryt Salvo
**Date:** **" current-date "**

**Fall 2024 | CS7300 Unsupervised Learning**

*************

This project contains solutions to Homework 1 from the Unsupervised Learning course (CS7300) using Clojure. The primary purpose is to answer the given questions and demonstrate understanding of the concepts. While Clojure is used throughout the notebook, it's important to note that the implementation serves as a learning tool to better understand the processes in action. Leveraging high performance libraries like [`Neanderthal`](https://neanderthal.uncomplicate.org/) and [`Tablecloth`](https://github.com/scicloj/tablecloth) to showcase the implementation of key concepts.

Code in this notebook demonstrates certain applications of various linear algebra techniques, such as matrix multiplication, normalization, and standardization. Not all methods mentioned are implemented in code (e.g. Lasso, Ridge regression, or PCA). The Clojure implementations provided focus on demonstrating key concepts I could quickly enough hack together and serve as practical examples where feasible.

The code is organized into different sections corresponding to each homework problem, with detailed explanations of the algorithms and mathematical concepts involved. We utilize Clojure and its associated libraries, such as `scicloj.clay` for rendering, `tablecloth` for data manipulation, and `fastmath` for mathematical operations.

#### Utils

The `utils.clj` file contains various utility functions and helpers used throughout the homework solutions. It includes:

- Formatting functions for markdown and LaTeX rendering
- Data preprocessing and normalization functions
- Helper functions for implementing unsupervised learning algorithms

These utilities are designed to streamline the implementation process and provide reusable components for data analysis and visualization in the context of unsupervised learning.

The code in the `src/assignments` folder was rendered with [Clay](https://scicloj.github.io/clay/) and deployed with [Github Pages](https://pages.github.com/).")))
