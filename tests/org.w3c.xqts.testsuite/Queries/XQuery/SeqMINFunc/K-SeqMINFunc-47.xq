(:*******************************************************:)
(: Test: K-SeqMINFunc-47                                 :)
(: Written by: Frans Englich                             :)
(: Date: 2006-10-05T18:29:41+02:00                       :)
(: Purpose: Simple test for min() involving xs:date.     :)
(:*******************************************************:)
min((xs:date("2005-01-01"), xs:date("2001-01-01")))
						eq xs:date("2001-01-01")