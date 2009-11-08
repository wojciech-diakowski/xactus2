(:*******************************************************:)
(: Test: K-SeqExprCast-1407                              :)
(: Written by: Frans Englich                             :)
(: Date: 2006-10-05T18:29:39+02:00                       :)
(: Purpose: 'castable as' involving xs:anyURI as source type and xs:gDay as target type should always evaluate to false. :)
(:*******************************************************:)
not(xs:anyURI("http://www.example.com/an/arbitrary/URI.ext") castable as xs:gDay)