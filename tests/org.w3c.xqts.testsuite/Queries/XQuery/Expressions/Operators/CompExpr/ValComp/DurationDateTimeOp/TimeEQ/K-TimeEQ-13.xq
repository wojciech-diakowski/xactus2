(:*******************************************************:)
(: Test: K-TimeEQ-13                                     :)
(: Written by: Frans Englich                             :)
(: Date: 2006-10-05T18:29:37+02:00                       :)
(: Purpose: The operator 'ge' is not available between xs:dateTime and xs:date . :)
(:*******************************************************:)
xs:time("12:12:23") ge
				       xs:date("1999-12-04")