(:*******************************************************:)
(: Test: K-ForExprPositionalVar-13                       :)
(: Written by: Frans Englich                             :)
(: Date: 2006-10-05T18:29:37+02:00                       :)
(: Purpose: Verify that the position is properly computed for fn:insert-before()(#2). :)
(:*******************************************************:)
deep-equal((1, 2, 3, 4),
	    for $i at $p
	    in insert-before((1, current-time()), 1, (current-date(), 3))
	    return $p)