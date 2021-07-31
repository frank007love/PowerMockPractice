package org.tonylin.mockito;

import java.util.ServiceLoader;

public class CommandCreator {
	public <T extends Command> T createCommand(Class<T> cmdType) {

		for( Command cmd : ServiceLoader.load(cmdType)){
			if( cmd.canExecute() ) {
				return cmdType.cast(cmd);
			}
		}

		throw new RuntimeException("Can't find valid command");
	}
}
