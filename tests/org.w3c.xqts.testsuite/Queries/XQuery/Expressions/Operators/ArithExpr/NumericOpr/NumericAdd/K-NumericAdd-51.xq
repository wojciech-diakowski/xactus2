(:*******************************************************:)
(: Test: K-NumericAdd-51                                 :)
(: Written by: Frans Englich                             :)
(: Date: 2006-10-05T18:29:36+02:00                       :)
(: Purpose: Implementations supporting the static typing feature may raise XPTy0004. :)
(:*******************************************************:)
(remove((1, "two"), 2) + 1) eq 2