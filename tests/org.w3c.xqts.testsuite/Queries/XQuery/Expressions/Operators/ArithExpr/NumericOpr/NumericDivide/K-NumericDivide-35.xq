(:*******************************************************:)
(: Test: K-NumericDivide-35                              :)
(: Written by: Frans Englich                             :)
(: Date: 2006-10-05T18:29:36+02:00                       :)
(: Purpose: A test whose essence is: `(xs:untypedAtomic("3") div xs:double(3)) eq 1`. :)
(:*******************************************************:)
(xs:untypedAtomic("3") div xs:double(3)) eq 1