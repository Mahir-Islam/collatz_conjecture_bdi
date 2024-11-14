package example;

// Environment code for project collatz

import jason.asSyntax.*;
import jason.environment.*;
import jason.asSyntax.parser.*;

import java.util.logging.*;

public class Env extends Environment {

    private Logger logger = Logger.getLogger("collatz."+Env.class.getName());

    /** Called before the MAS execution with the args informed in .mas2j */
    @Override
    public void init(String[] args) {
        super.init(args);
        try {
            addPercept(ASSyntax.parseLiteral("percept("+args[0]+")"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean executeAction(String agName, Structure action) {

        //If the agent sends an action called check()
        if (action.getFunctor().equals("check")) {
          
        //l is defined as the value in check(l)
        int l = Integer.parseInt(action.getTerm(0).toString());

          if      (l % 2 == 0) {addPercept(Literal.parseLiteral("even(" + l + ")" ));}
          else if (l % 2 == 1) {addPercept(Literal.parseLiteral("odd(" + l + ")"  ));}
          return true;
        }

         if (action.getFunctor().equals("clear")) {
          clearPercepts();
          return true;
        }

         else {
          logger.info("executing: "+action+", but not implemented!");
          return false;
        }
    }

    /** Called before the end of MAS execution */
    @Override
    public void stop() {
        super.stop();
    }
}