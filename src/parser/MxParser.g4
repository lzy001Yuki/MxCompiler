grammar MxParser;
import MxLexer;
@header {package parser;}
program: (funcDef | classDef |varDef )* mainDef (funcDef | classDef |varDef )* EOF;

funcDef : returnType funcName  '(' para? ')' block;
returnType : Void | typename;
funcName : Identifier;
para : typename Identifier (Comma typename Identifier)* ;

mainDef : Int Main '('')' block;

className : Identifier;
constructor : className '('')' block;
classDef : Class className '{' (varDef | constructor | funcDef)*  '}' ';';

typename: (Int | Bool | String | Identifier)('['']')*;
atom:Identifier | False | True | Integer | Str | Null | This | stringFormat;
expr
    : New (Int | Bool | String | Identifier) ('['expr']')+ ('['']')*  ('{'(expr (Comma expr)*)?'}')?    #arrayExpr1
    | '{'(expr (Comma expr)*)?'}'      #arrayExpr2
    | New (Int | Bool | String | Identifier) ('('')')?       #varExpr
    | expr ('['expr']')+    #indexExpr
    | expr '('(expr (Comma expr)*)?')'       #funcExpr
    | expr op=Dot Identifier        #memberExpr
    | <assoc=right> op=(Not | Tilde | Add | Sub) expr       #unaryExpr
    | expr op=(Incre | Decre)      #postfixExpr
    | <assoc=right> op=(Incre | Decre) expr     #prefixExpr
    | expr (Mul | Div | Mod) expr       #algorExpr1
    | expr (Add | Sub) expr     #algorExpr2
    | expr (LeftShift | RightShift) expr        #shiftExpr
    | expr (GT | GET | LT | LET | NEQ | EQ) expr        #compExpr
    | expr And expr      #andExpr
    | expr Caret expr       #xorExpr
    | expr Or expr      #orExpr
    | expr AndAnd expr      #andandExpr
    | expr OrOr expr        #ororExpr
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
    | If '(' expr ')' stat (Else stat)?     #ifStat
    | While '(' expr ')' stat       #whileStat
    | For '(' stat1 = stat stat2 = expr?';' stat3 = expr? ')' stat      #forStat
    ;

