(:*******************************************************:)
(: Test: K-DayTimeDurationEQ-6                           :)
(: Written by: Frans Englich                             :)
(: Date: 2006-10-05T18:29:37+02:00                       :)
(: Purpose: The xs:dayTimeDuration values -PT0S and PT0S are equal. :)
(:*******************************************************:)
xs:dayTimeDuration("-PT0S") eq xs:dayTimeDuration("PT0S")