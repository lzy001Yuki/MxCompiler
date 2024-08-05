grammar MxParser;
import MxLexer;
@header {package parser;}
program: (funcDef | classDef |varDef )* mainDef (funcDef | classDef |varDef )* EOF;

funcDef : returnType Identifier  '(' para? ')' block;
returnType : Void | typename;
para : typename Identifier (Comma typename Identifier)* ;

mainDef : Int Main '('')' block;

constructor : Identifier '('')' block;
classDef : Class Identifier '{' (varDef | constructor | funcDef)*  '}' ';';

typename: (Int | Bool | String | Identifier)('['']')*;
atom:Identifier | False | True | Integer | Str | Null | This | stringFormat;
expr
    : New (Int | Bool | String | Identifier) ('['expr?']')+  ('{'(expr (Comma expr)*)?'}')?    #arrayExpr1
    | '{'(expr (Comma expr)*)?'}'      #arrayExpr2
    | New (Int | Bool | String | Identifier) ('('')')?       #varExpr
    | expr ('['expr']')+    #indexExpr
    | expr '('(expr (Comma expr)*)?')'       #funcExpr
    | expr op=Dot Identifier        #memberExpr
    | <assoc=right> op=(Not | Tilde | Add | Sub) expr       #unaryExpr
    | expr op=(Incre | Decre)      #postfixExpr
    | <assoc=right> op=(Incre | Decre) expr     #prefixExpr
    | expr op=(Mul | Div | Mod) expr       #algorExpr1
    | expr op=(Add | Sub) expr     #algorExpr2
    | expr op=(LeftShift | RightShift) expr        #shiftExpr
    | expr op=(GT | GET | LT | LET | NEQ | EQ) expr        #compExpr
    | expr op=And expr      #andExpr
    | expr op=Caret expr       #xorExpr
    | expr op=Or expr      #orExpr
    | expr op=AndAnd expr      #andandExpr
    | expr op=OrOr expr        #ororExpr
    | <assoc=right> expr '?' expr ':' expr      #ternaryExpr
    | <assoc=right> expr op=Assign expr     #assignExpr
    | '(' expr ')'      #basicExpr
    | atom        #atomExpr
    ;
varDefAtom : Identifier (Assign expr)?;
varDef : typename varDefAtom (Comma varDefAtom)* ';';


head : 'f"' FormatStr '$';
middle : '$' FormatStr '$';
tail : '$' FormatStr Quote;
stringFormat : Format1 | (head expr? (middle expr?)* tail);

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
    | For '(' init = stat condExpr = expr?';' stepExpr = expr? ')' stat      #forStat
    ;

