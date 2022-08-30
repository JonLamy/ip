import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

import ip.Parser;
import ip.command.ByeCommand;
import ip.command.Command;
import ip.command.ListCommand;
import ip.exception.InvalidCommand;



public class ParserTest {
    private final Parser parser = new Parser();

    @Test
    public void getCommandTest_blankInput_returnByeCommand() {
        parser.load(new Scanner(""));
        try {
            Command command = parser.getCommand();
            assertTrue(command instanceof ByeCommand);
        } catch (InvalidCommand e) {
            fail();
        }
    }

    @Test
    public void getCommandTest_listCommand_returnListCommand() {
        parser.load(new Scanner("list"));
        try {
            Command command = parser.getCommand();
            assertTrue(command instanceof ListCommand);
        } catch (InvalidCommand e) {
            fail();
        }
    }
}
