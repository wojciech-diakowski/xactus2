(:*******************************************************:)
(: Test: K-QuantExprWithout-56                           :)
(: Written by: Frans Englich                             :)
(: Date: 2006-10-05T18:29:37+02:00                       :)
(: Purpose: A test whose essence is: `true() eq (some $fn:name in (1, 2) satisfies $fn:name)`. :)
(:*******************************************************:)
true() eq (some $fn:name in (1, 2) satisfies $fn:name)