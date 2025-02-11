package lexer

import modelo._

def leerCalculoLambda(expresion :String): List[CalculoLambda]= {
   tokenizar(expresion.toList)
}

def tokenizar(caracteres: List[Char]): List[CalculoLambda] = caracteres match {
  case Nil => List()
  case 'λ' :: tail => LAMBDAstr() :: tokenizar(tail)
  case ' ' :: tail => SPACE() :: tokenizar(tail)
  case '.' :: tail => DOT() :: tokenizar(tail)
  case '(' :: tail => LPAR() :: tokenizar(tail)
  case ')' :: tail => RPAR() :: tokenizar(tail)
  case x :: tail => VAR(x.toString) :: tokenizar(caracteres.tail)
}
