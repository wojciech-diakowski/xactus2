(:*******************************************************:)
(: Test: K-HexBinaryEQ-4                                 :)
(: Written by: Frans Englich                             :)
(: Date: 2006-10-05T18:29:37+02:00                       :)
(: Purpose: Complex comparison test of wrapped hexBinary/base64Binary constructor functions. :)
(:*******************************************************:)
xs:hexBinary(xs:base64Binary(xs:hexBinary("03")))
		eq xs:hexBinary("03")