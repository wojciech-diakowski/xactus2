(:*******************************************************:)
(: Test: K-QuantExprWithout-47                           :)
(: Written by: Frans Englich                             :)
(: Date: 2006-10-05T18:29:37+02:00                       :)
(: Purpose: A test whose essence is: `not(every $var in (1, 2, 3) satisfies $var eq 3)`. :)
(:*******************************************************:)
not(every $var in (1, 2, 3) satisfies $var eq 3)