(:*******************************************************:)
(: Test: K-ForExprWithout-21                             :)
(: Written by: Frans Englich                             :)
(: Date: 2006-10-05T18:29:37+02:00                       :)
(: Purpose: A for variable binding to the empty sequence, combined with value comparison. :)
(:*******************************************************:)
empty((for $var in () return 1) eq 1)