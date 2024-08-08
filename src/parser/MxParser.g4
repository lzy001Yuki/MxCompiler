parser grammar MxParser;
options { tokenVocab = MxLexer; }
program: (funcDef | classDef |varDef )* mainDef (funcDef | classDef |varDef )* EOF;

funcDef : returnType Identifier  '(' para? ')' block;
returnType : Void | typename;
para : typename Identifier (Comma typename Identifier)* ;

mainDef : Int Main '('')' block;

constructor : Identifier '('')' block;
classDef : Class Identifier '{' (varDef | constructor | funcDef)*  '}' ';';

typename: (Int | Bool | String | Identifier)('['']')*;
atom:Identifier | False | True | Integer | Str | Null | This | stringFormat;
initArray:('{'(expr (Comma expr)*)?'}');
expr
    : New (Int | Bool | String | Identifier) ('['expr?']')+  initArray?    #arrayExpr1
    | initArray      #arrayExpr2
    | New (Int | Bool | String | Identifier) ('('')')?       #varExpr
    | expr ('['expr']')+    #indexExpr
    | expr '('(expr (Comma expr)*)?')'       #funcExpr
    | expr op=Dot Identifier        #memberExpr
    | <assoc=right> op=(Not | Tilde | Add | Sub) expr       #unaryExpr
    | expr op=(Incre | Decre)      #postfixExpr
    | <assoc=right> op=(Incre | Decre) expr     #prefixExpr
    | expr op=(Mul | Div | Mod) expr       #algorExpr
    | expr op=(Add | Sub) expr     #algorExpr
    | expr op=(LeftShift | RightShift) expr        #bitExpr
    | expr op=(GT | GET | LT | LET | NEQ | EQ) expr        #logicExpr
    | expr op=And expr      #bitExpr
    | expr op=Caret expr       #bitExpr
    | expr op=Or expr      #bitExpr
    | expr op=AndAnd expr      #logicExpr
    | expr op=OrOr expr        #logicExpr
    | <assoc=right> expr '?' expr ':' expr      #ternaryExpr
    | <assoc=right> expr op=Assign expr     #assignExpr
    | '(' expr ')'      #basicExpr
    | atom        #atomExpr
    ;
varDefAtom : Identifier (Assign expr)?;
varDef : typename varDefAtom (Comma varDefAtom)* ';';


stringFormat : Format1 | (Head expr? (Middle expr?)* Tail);

block : '{' stat* '}';

stat
    : block       #blockStat
    | varDef        # varStat
    | Return expr? ';'      #returnStat
    | Break ';'     #breakStat
    | Continue ';'      #contStat
    | expr ';'      #exprStat
    | ';'       #noneStat
    | If '(' expr ')' ifStat = stat (Else elseStat = stat)?     #ifStat
    | While '(' expr ')' stat       #whileStat
    | For '(' (init1 = varDef | init2 = expr?';')  condExpr = expr?';' stepExpr = expr? ')' stat      #forStat
    ;

