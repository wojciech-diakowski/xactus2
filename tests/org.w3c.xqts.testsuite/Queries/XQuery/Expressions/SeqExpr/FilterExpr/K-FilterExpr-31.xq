(:*******************************************************:)
(: Test: K-FilterExpr-31                                 :)
(: Written by: Frans Englich                             :)
(: Date: 2006-10-05T18:29:36+02:00                       :)
(: Purpose: A test whose essence is: `deep-equal((1, 2, 3), (1, 2, 3)[true()])`. :)
(:*******************************************************:)
deep-equal((1, 2, 3), (1, 2, 3)[true()])