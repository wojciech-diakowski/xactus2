(:*******************************************************:)
(: Test: K-GenCompLTEQ-8                                 :)
(: Written by: Frans Englich                             :)
(: Date: 2006-10-05T18:29:37+02:00                       :)
(: Purpose: General comparison causing a xs:untypedAtomic value to be cast to xs:boolean, and then compared. :)
(:*******************************************************:)
true() <= xs:untypedAtomic("true")