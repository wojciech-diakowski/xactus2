(:*******************************************************:)
(: Test: K-ForExprPositionalVar-2                        :)
(: Written by: Frans Englich                             :)
(: Date: 2006-10-05T18:29:37+02:00                       :)
(: Purpose: Position variable which is not in scope.     :)
(:*******************************************************:)
for $a at $p1 in (1, 2), $b at $p2 in (1, 2), $c at $p3 in (1, 2) return 1, $p1