(:*******************************************************:)
(: Test: K-TimeGT-3                                      :)
(: Written by: Frans Englich                             :)
(: Date: 2006-10-05T18:29:37+02:00                       :)
(: Purpose: Simple test of 'lt' for xs:time.             :)
(:*******************************************************:)
not(xs:time("23:01:05.12") lt
			       xs:time("23:01:04.12"))