(:*******************************************************:)
(: Test: K-QuantExprWithout-95                           :)
(: Written by: Frans Englich                             :)
(: Date: 2006-10-05T18:29:37+02:00                       :)
(: Purpose: It is a type error to try to extract the EBV value of two integers. :)
(:*******************************************************:)
some $i in (1, 2, 3) satisfies ($i, $i)