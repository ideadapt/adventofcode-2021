package day10

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class ParserTest {

	val big = """
		{[<<([[{{[<[[[<>()]{[]<>}]]<[[{}()>{[]{}}]>>][((<{{}[]}{[][]}>({{}{}}{{}[]})))([{({}[])}(<
		[[{[<[<[<<([[<<>[]>([]())][<<>[]><<>{}>>][(<{}()><<>>)]){{<<(){}><[]<>>>{([][])<[]{}>}}{[<[]<
		<[([[[({[([<<[[]()]{[]{}}>(<[]{}>{{}()})>{{(<><>)[{}()]}([()<>][<>])}]{[{({}())[[]{}]}]((<<>[]>)<(<>())
		{[(({<{[{{[{[[[][]]<[]()>]<[{}[]]>}[<(()<>)<{}[]>>{([][])(()())}]](<<{()<>}>[{<>{}}{{}<>}]>)}(([([(){}]<<
		<{[[{[<<[({(({<>{}}(<>{})){{{}()}(<>{})})<<<<>()>{()}>{[{}()][()<>]}>}{([{{}{}}]<{{}()}((){})>)({<[](
		<<<[[<({(<(([<{}()>]([()]{()}))<{{{}<>}<<>()>}[[()<>]<<><>>]>)>)[({[({<><>}<<>[]>){[{}()]{()<>}}][{<{
		{{(({<<{{[((<(<>[])<[]()>><[<>[]](()[])>)[({()}({}[]))[({}<>)[{}<>]]])[([([]<>)<()<>>}{[(){}]
		<{[{<(([{[{{{{<>[]}<()<>>}(((){})<[][]>)}{[[{}<>]]<{<>{}}{<><>}>}}]}{<{[<[()()][<>()]>(<<>[]><()<>})](
		(<((<[<(([[((({}<>)<{}()>){{[]}[()<>]})([{[][]}<<>()>])]{<[{<>()}[<>()]][([]())<[]()>]>[(<{}[]>(()())){([
		[{(<{[<(([<<<<[]()>[<>{}]>[((){})(()<>)]><(([]<>){()<>}){[{}]{[]()}}>>([<<<>[]>{<>{}}>{<[]{
		<{[<({{[(<<<[{()[]}][[(){}]<<>()>]>>>((<[<[]()>(<>())][[[]<>](<><>)]>(<<[]()><<>[]>>({()}<<>[]>)))[
		{(([[(<[[<{[(<[]<>><<><>>)]}>]]>{[[{([{<{}{}>[<>[]]}<[<>{}]<()<>>>][{<{}>{<><>}}{{{}[]}([]())}])
		{<<{<[<[<<({{(()[])}<{{}{}}([]())>})[(<{{}{}}((){})>[[<>[]][<>[]]])[{<[]()>{{}<>}}{{[]{}}<[]()>}]]>>]>{
		<([{{{{(<((<{[{}[]][[]<>]}>{<(<>{})(<><>)}})[{(<<>>({}{}))(({}{}){[]})}])<<<{<<>[]>{()[]}}>{<({}[])>[[[]<
		({<{<(<[<<(<{[<><>]<{}()>}[({}{}){()[]}]><<(()<>){{}{}}>(<[][]>[[][]])>)>{<[(<{}[]>[()()])({[]()}<
		{[{({<(((<[{(({}())(<><>))<[<>{}]{()[]}>}([([]<>)([][])}(<[]{}><[]{}>))](([([][])({}<>)]([[]()]{[]
		(((([<[(<[<<[{<><>}{{}<>}]<<()>>>>]>{([{<({}{})>[(()<>)[()()]]}[{([]())[{}[]])({{}<>}{{}{}})]])[((<<(){}
		{([(({[[<[{([[<>()]][(<>[])([]{})]><<(()<>)([]{})>([<>{}])>}([<<{}[]>(<>[])>{[()<>]<()[]>}]{[[[][]][[]()]]
		[[<({<<<<(<([({}())[<>{}]]{[()<>]{{}[]}})((<<><>>[<>{}])<(<>{}){{}()}>)]<<<{<>{}}((){})>([[]()]{{}})><(({}<
		<[{[{{<([(({[[<><>]{<><>}]}<((()<>))[<()()>{[][]}]>)[(({<><>}({}())){<[]()>})])<(<<[()<>]((){})><[()<>](<>
		[{{{{[[{{{(<{{[]<>}{<>{}}}<{[]{}}[[]]>><({()()}{<><>})[(<><>)]>)}[(<<(<><>)([][])>[[()[]]{()<>}]>{(<
		((<({(<({{{[{{{}<>}<[]{}>}{{[]{}}{{}[]}}](<[<>()]>)}}<([{[{}{}]{<>()}}<<()[]>([]<>)>]<<[()[
		<[<([(<{[(<[[{[]{}}{{}}](([]{})([][]))][[<[][]>{{}<>}]<[{}<>][[]]>]>[{<({}{})<[][]>>[{<>}]}{<[{}[]]>}]
		{(({{[<([[{((([]<>)[<>()])[({}{})(()<>)])(<{[]<>}([]<>)>{<<>()>({}<>}})}][<{[{<>{}}<()<>>](<<><>>({
		<{({(({{<{[(({{}<>})[<[][]>])]<<[<{}[]>(()[])]<(<><>)[<><>]>]{{{()[]}(<><>)}({()()}[<>{}])}>
		<[<<[<[{({[<[<()()><[]{}>]{<{}{}>[[]{}]}>[<[[]<>]<<>[]>><{<>[]}([]{})>]]})}[[[<[<[<>]<()()>>({()[]}<()<>>
		[(<<{<[[{((<({[]<>}[()[]])(<[]{}>({}[]))>(((<><>)<{}<>>)<{[]{}}<[][]>>)))}[<[((<(){}>{[]})[[[]<>]([]<
		[{[({[{<<{<<(<<>{}>{[]()})[{[][]}<{}{}>]><([{}[]][<>()])({[][]})>>[<{<()()>[{}<>]}<([]{})(<>{})>><[(()()){(
		{<([[{<[(<<<[<[][]>]({()[]}{[][]})>>{{{[{}<>][[]{}]}[{{}()}(<>())]}<([[][]]{()[]})<{{}{}}<(){}>>>}>[[(
		({[[((<<{[<{{([][])(<>[])}<[()[]][[]{}]>}[<[<>{}]([]{})><(<>[])<(){}>>]>[[[({}{})((){})){<()<>>{{}
		{<<{({({[{{{{(<>{})({})}<({}()>(()[])>}[<[<>[]]>{{<>{}}(()<>)}]}[<{<()<>>{<>{}}}[<[]{}>(<>())]>(<[{}(
		[[{<((<<[[{<(<()[]>([]{}))<<<>{}>(())>>[({[]<>}(()<>))<({}<>)<[]<>>>]}](({<[()[]][{}]>}<(([]<>)<<>>)
		<{{((((<{([([(<>[]){()()}]{(<>())([]())})]{[<(<>[])>{[()[]]<[]<>>}]<(({}<>)({}()))>})<[<{<{
		<[({<<[{<[<([([]{})[()())][<()[]><<>()>])([(<>())])><[<[()<>]><{<><>}<[]>>]>]([{[[<>{}]{{}{}}]<{
		<[{[[<{[<({<((()[]){{}[]})<(<>[])[<>()]>>})>]}>][(([((<[{({}{})<[]{}>}]<([<>{}](()()))(<<>{}><(
		<{[[([{[<([(<(<>[])><([][])[[][]]>)(({<>[]}[{}()])[{()<>}{<>}])]<(<(()[])<<>{}>>{<<><>>[[]()]}){<{<>()}{
		{<{<{{<({<(<<{()()}>({[]{}}[{}{}])>)<<({{}()}({}{}))<{[]()}{<><>}>>[[<()()>(<>())]]>]})<<{[[((
		((<((<<([({([{[]<>}[()()]][[[][]]({}())])})(([<<[]<>>(<>)>]<{({}[]){{}}}{<{}[]>({}())}>){<
		{<((<<[<{{[({<[]()>{[]{}}}({[][]}[{}{}]))[<[[]{}]{{}[]}>]]}[{[<[()()]<<>[]>>]{[<<>{}>(<>{})](
		<{<<{({[<<<<([()<>]<<>[]>)(<()><{}()))><{<[]{}>[[]]}>>>[{([[{}<>]](<<>[]><{}<>>))[(({}{}){{}[]})((<>[])[<>(
		{<[{(<<[{(<(((()())[{}{}])<{()<>}[{}]>){{{()}{[]<>}}[[[]<>]{<><>}]}>)}({<<(({}()))<([]()}[<><>]>>{[[<>()]
		<([[[<<([(<([(()())][<{}()>((){})])(([<>()]{<>[]})[[(){}]<()<>>])>)(([[{{}[]}[{}()]][<(){}><(){}>]]{{<<>{}>
		(([([{{{<([<<{(){}}<()<>>>{<<><>>[{}()]}>({<<>{}>[()()]}<<<>{}>>}])[{{[([]())({}<>)]<<<>()>[()[]]
		{(<({<([{([{(({}))[{<>[]}[{}()]]}[({()<>}{<>()})<([]()){{}()}>]]({<<[][]>([]<>)><{()<>}{(){}}>
		[[{({{{({<(<[({}<>)([]())]>(({{}{}}{()<>})>)[{{<<>{}><[]{}>}<<[][]><[][]>>}<(([]<>)<{}{}>)>]>
		([{{([(({({<[{()[]}<[]()>]<<{}<>><()[]>>>(<(<>[])<{}{}>>([{}{}]({}())))}([({{}[]>{{}{}})<<{}()><{}>>]<{<{}{}
		[<((<<[{[[[<(<<><>><<>()>)>]]]{<{<<[{}<>][{}{}]>(<{}[]>([]()))><<<<>{}>>{[<>{}]{<>[]}}>}[{(
		(((<({{[(({[[([]{})({}{})](([]{}){{}{}})]{(<[]{}>[[]()])(<()()><()<>>)}}))<{[{(<{}>{[]<>})}{
		[([{{(<<({(<<<[][]>{[]<>}){({}())[[]{}]}>){[({<>[]}{[]<>})]{({()<>}{()[]})}}}[(([[()[]][()()]](<<>{}>
		[<{({<<([<[[{[[]{}>{<>()}}<[<>{}]{()<>}>]]>{[(<([]{}){{}[]}>{{[]{}}(<>[])})((({}<>)(()()))[<
		<<<([{{<[<([[{<>()}[[]<>]]][<<()()>{()<>}>[[<>{}]<{}<>>]]){((<[]{}><{}<>>))}>[[(<([]())>(({}[])))
		{({<([[{({{{[{<>{}]<[]()>]}([<[]<>><()<>>][([]<>)<{}()>])}[{<{{}{}}<()<>>>}]}[{[[<<>[]>([][])][<<>{}>[<
		(((([[[((<[<[((){})<{}<>>]>(<[{}](()<>)><[<>{}][<>()]>)]>([(([()[]]<{}>)([<>[]]{()()}))]))(<[<<{<>()}<{}>>(
		<{[((([[({[<<[{}()>[{}{}]>>{[(()())[{}{}]]}]})<[[((([]<>)<<>[]>){({}<>){<>()}})<<[<>[]]([]())>([{}[]
		{<([[{<[{{<{{([][]><<><>>}<{()()}<[]()>>}<(({}<>)<{}[]>)>>}}[{(([(<><>)<[][]>]{(()())}){{(()[
		<(({([({<[(((<[]>)({{}<>}[[]{}])))[[[(<><>)(<>[])]<{<>}([]{})>]{(({}{}))<{{}<>}{[]{}}>}]]{<{{([
		<[[{(<[{(<([(([]<>)[<>])])>)}<{[({({()<>}[<>{}])<{<><>}<{}{}>>}{<[<>[]]<<>[]>>[{()()}[{}<>]]}){{<<[][]>({}<
		<[{(<{[[[[{[[<[]{}>{[]<>}]<[{}{}]<{}<>>>]((<{}<>>)[{()}(<>[])])}({[{{}()}[{}()]][<(){}}(()<>)]}<[[
		<<(<[[<<([{<({()<>}(()<>)>([()][[]{}])>}])>{[([[<[<><>]({}{})>(<<><>>{()<>})]][(({{}()}{()()})<{<>()}[[]<
		<(<({<[{<{<[{{{}()}({}<>)}<[[]()][<>{}]>]>((<[()<>]{[]<>}>((<>())<[]()>)))}{[(([()()]<(){}>){<()<>>[
		[[[([{<([<<<{[()<>]{()[]}}<([]())[{}[]]>><<[[]<>]>{<[]{}><<>()>}>>([{{[]<>}(()())}[<<>>{<>{}}]](([<>()]<<>()
		{<([{[{{<[<[[{{}}([]{})]]<<{<>{}}><[(){}]>>>(([(<>)<()[]>][{{}[]}(<>[])]){<{<>[]}<<>[]>>{<<>[]>{
		{[[{<[[<<[[([{()[])[[][]]]{{()()}})]]>>[{{<[{(<><>)}<<()[]>({}())>]<[({}<>)]>>[[{[[]()]<<>{}>}[[<>{}]<()
		[({{{<[([[{[[({}{})][<<>{}>{{}[]}]]({<[][]>}(({}<>)({}<>)))}<[{({})}({()()}<[]{}>>]((<[]{}>[{}{}]))>]{{{<{[]{
		<[<<[{[{{<(<{{()<>}{{}{}}}[[[]{}]]>[[<()()><[]()>]([[]{}])])>[{[[([]()){()}][([]())[<>[]]]]}]}}{<[[[(<{}()>{{
		<[{<{[[<<([[{(<><>)[(){}]}]]((([()<>]<<>[]>)[<[][]>({}<>)])))[<[<[<>()][(){}]}{[()()]}]{({()()}(()
		[<{[((<<{((<({{}<>}{()[]}){{{}[]}(()())}]{<<{}()>{<>()}>})([{[{}{}][[]()]}<[{}[]]<<>()>>]))}<<{(
		{({{([([[{{(<<()<>><(){}>>)<[({}())(<><>)]{[<>()][()[]]}>}({[{{}<>}[[]{}}]}{(<{}[]><{}>)(<[][]>[{}<>
		({[[<({{[<((((()<>)<()<>>)<{[][]}[[]<>]>)({(()<>){{}[]}][(()[])[[][]]]))([<<()()>{<><>}>({{}[]}((){})
		{<{[(<(<({{<<(<>[])<<><>>><<[][]>(()[])>>[[([]<>)([]<>)][<()()>]]}}{(<{{<><>}(()<>)]{[[]()]
		[[[[<[{{[{<[<[<><>]>](<(()[]){{}[]}><(<>{})[{}()]>)>(<{{[]<>}<<><>>}[<{}<>>[{}()])>)}({[<<(
		[{{<{[(([{{{((<>[])<{}{}}){<{}[]>([])}}{<{<><>}({}[])>{{()[]}{[][]}}}}<<{[<>{}](<><>)}<{{}
		<[[{(<[{(({<<<<>[]><{}<>]><<()()><()()>>>{[<()<>>{[]}]<<()()>{[][]}>}}[{(<{}[]>[{}[]])}{[{{}<>}
		{[((<{([[({<([()<>][[][]])([()()]{[][]})>[[[{}]>({[][]}{[][]})]}<[[{<>[]}<()()>]{<[]()>}]>)][[<{
		(<<{(({[[<[<<[{}<>]>{{{}<>}((){})}>][<[{()[]}{{}[]}]>(<{<>{}}[<><>]>{[[]{}]<{}()>})]>]<[[[{[()[]]({}[])}([{}
		[[{([<<{[<([{{(){}}{{}[]}}[{<>()}]][<[<>{}}[[]]>({[]{}}<<>[]>)])(({[{}{}](()<>)}[(<><>){{}()}]))
		<<<({[{[<<((({<>{}})({<>{}}<[]<>>)))[<[<{}<>><{}<>>]([[]{}][()<>])>(([{}{}]{{}<>})({[]{}}[[]<
		{[[[[[{{<<<<{[{}()]([][])}{<[]()>({}{})}>([[[]{}]][[(){}][{}{}]])>{([[{}{}]({}<>)]([<><>][()<>]))}>
		[[<(([[(([[(([()[]]<{}<>>){{{}()}[[]()>})][<[[(){}][[]{}]][<{}[]><[]<>>]>{(<<>{}><()()>)(<()()><{}[]>)
		[<([(<[<<(([{{{}()}<{}[]>}[<<>()><<>()>]]))({<<{[]()}>{{[][]}<[]{}>}}[{([])<[][]>}]}{<[[[]()]{<>{}}]{<[][]>}
		{{{[[[{<<{<(<[{}{}](<>())>[{[][]}[{}<>]])[[(()[])({}())]{([]{})(()<>)}]>((([{}]{[]<>}))([{()[]}{{}
		[[(([{<[((<([{{}()}[()<>]]{<<><>>[[]<>]})([[<><>]([])]((<>()){<>[]}))><(<({})<()()>>)(<<<>{}>([]())>{<[][
		(<{({(<<(<{(({{}()}<[]<>>))[<<{}{}>[(){}]>]}<[(({}{})<()()>)[{()()}<[]>]](([[][]])([(){}]<[]()>))>>)
		<[{[<(<(({[<[(()<>)]{<()()><[]()>}>[{(<><>)[[]{}]}{({}<>)<(){}]}]]{(<[()<>]{<><>}>[{{}<>}({}[
		<[(<<[{{[[[<<<[]()><[]{}>>[([]()){()[]}]>({[[]()]<{}{}>}{[()[]]<{}{}>})]]]{([{<<{}[]>>}][[[[<>
		<{[[({{[<<<[<({})[[]]>]>>{[[[[()<>][()()]](<{}<>>)](<<[][]>[[]<>]>)]}>[<<[<<(){}>[<>()]>]<(((){}){{}
		[(<[<(<<{[([[{<>[]}([]())]<([]<>)[<>()]>]<[{(){}}[[][]]](<[]{}><{}<>>)>)]<{<<<[][]>>({(){}}[{}<>])
		{({([[{{(((<(<[]()>{<><>})(<(){}}<()[]>)><[{()[]}(()())][[{}<>]{[]{}}]>){([[{}{}](())])(<<()<>>[[][]
		(([[[<([[<[<[<{}{}>][<(){}>[<>[]]]>(([[]()][()]}{<[]{}><[]<>>})][(({()<>}<[]<>>)[[[]]]){[{()[]}<()()
		({{<[(([[{<<<[[][]]>[{()<>}<{}()>]>>(<<{()}[()<>]>><{(()<>)([]{})}>)>](<({{{()[]}[(){}]}[{{}{}}
	"""

	val small = """
		[({(<(())[]>[[{[]{<()<>>
		[(()[<>])]({[<{<<[]>>(
		{([(<{}[<>[]}>{[]{[(<()>
		(((({<>}<{<{<>}{[]{[]{}
		[[<[([]))<([[{}[[()]]]
		[{[{({}]{}}([{[{{{}}([]
		{<[[]]>}<{[{[{[]{()[[[]
		[<(<(<(<{}))><([]([]()
		<{([([[(<>()){}]>(<<{{
		<{([{{}}[<[[[<>{}]]]>[]]
	"""

	@Test
	fun parse() {
		val score = parse(big.trimIndent().lines())
		Assertions.assertEquals(370407, score)
	}
}
