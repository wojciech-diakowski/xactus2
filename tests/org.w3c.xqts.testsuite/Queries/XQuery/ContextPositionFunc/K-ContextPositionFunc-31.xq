(:*******************************************************:)
(: Test: K-ContextPositionFunc-31                        :)
(: Written by: Frans Englich                             :)
(: Date: 2006-10-05T18:29:41+02:00                       :)
(: Purpose: position() combined with a comparison operator inside a predicate. :)
(:*******************************************************:)
deep-equal((1, 2, 3), (1, 2, 3, current-time())[4 > position()])