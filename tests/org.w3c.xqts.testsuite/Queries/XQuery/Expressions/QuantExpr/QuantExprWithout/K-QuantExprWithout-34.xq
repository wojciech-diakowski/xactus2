(:*******************************************************:)
(: Test: K-QuantExprWithout-34                           :)
(: Written by: Frans Englich                             :)
(: Date: 2006-10-05T18:29:37+02:00                       :)
(: Purpose: A test whose essence is: `not(every $var in (false(), true(), true()) satisfies $var)`. :)
(:*******************************************************:)
not(every $var in (false(), true(), true()) satisfies $var)