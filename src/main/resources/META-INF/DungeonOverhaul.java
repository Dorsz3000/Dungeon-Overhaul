
package pl.dorsz3000.dungeonoverhaul;

import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.RegisterCommandsEvent;

@Mod(DungeonOverhaul.MOD_ID)
public class DungeonOverhaul {

    public static final String MOD_ID = "dungeon_overhaul";

    public DungeonOverhaul(IEventBus modEventBus) {
        NeoForge.EVENT_BUS.addListener(this::registerCommands);
    }

    private void registerCommands(RegisterCommandsEvent event) {

        event.getDispatcher().register(
            Commands.literal("dungeon")
                .requires(source -> source.hasPermission(2))

                .then(Commands.literal("list")
                    .executes(context -> {
                        context.getSource().sendSuccess(
                            () -> Component.literal(
                                "Dungeon Overhaul: dostepny typ lochu: crypt"
                            ),
                            false
                        );
                        return 1;
                    })
                )

                .then(Commands.literal("spawn")
                    .then(Commands.literal("crypt")
                        .executes(context -> {
                            context.getSource().sendSuccess(
                                () -> Component.literal(
                                    "Crypt: generator lochu zostanie dodany w kolejnej wersji!"
                                ),
                                false
                            );
                            return 1;
                        })
                    )
                )
        );
    }
}
