(:*******************************************************:)
(: Test: K-InternalVariablesWith-4                       :)
(: Written by: Frans Englich                             :)
(: Date: 2006-10-05T18:29:39+02:00                       :)
(: Purpose: A variable declaration whose source expression doesn't match the declared type, and where it can be deduced statically. :)
(:*******************************************************:)
declare variable $myVar as xs:gYear := 2006; true()