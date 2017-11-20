(:*******************************************************:)
(: Test: K-DateTimeFunc-11                               :)
(: Written by: Frans Englich                             :)
(: Date: 2006-10-05T18:29:39+02:00                       :)
(: Purpose: Invoke fn:dateTime() with the second value having no timezone. :)
(:*******************************************************:)
dateTime(xs:date("2004-03-04+11:00"),
						    xs:time("08:05:23"))
				   eq
				   xs:dateTime("2004-03-04T08:05:23+11:00")