
package pl.dorsz3000.dungeonoverhaul;

import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.RegisterCommandsEvent;

@Mod("dungeon_overhaul")
public class DungeonOverhaul {

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
                                "Dostepne dungeon'y: crypt, catacombs, nether_fortress, end_ruins"
                            ),
                            false
                        );
                        return 1;
                    })
                )

                .then(Commands.literal("spawn")
                    .then(Commands.literal("crypt")
                        .executes(context -> {
                            context.getSource().sendFailure(
                                Component.literal(
                                    "Generowanie dungeonow nie jest jeszcze zaimplementowane."
                                )
                            );
                            return 0;
                        })
                    )
                )
        );
    }
}
public static final DeferredBlock<Block> DUNGEON_STONE = BLOCKS.register(
    "dungeon_stone", () -> new Block(BlockBehaviour.Properties.of()
        .strength(3.0F, 6.0F)
        .requiresCorrectToolForDrops()
        .sound(SoundType.STONE)));

public static final DeferredBlock<Block> CRACKED_DUNGEON_STONE = BLOCKS.register(
    "cracked_dungeon_stone", () -> new Block(BlockBehaviour.Properties.of()
        .strength(2.5F, 6.0F)
        .requiresCorrectToolForDrops()
        .sound(SoundType.STONE)));

public static final DeferredBlock<Block> REINFORCED_DUNGEON_BRICKS = BLOCKS.register(
    "reinforced_dungeon_bricks", () -> new Block(BlockBehaviour.Properties.of()
        .strength(-1.0F, 3600000.0F)
        .sound(SoundType.NETHERITE_BLOCK)));
registerBlockItem("dungeon_stone", DUNGEON_STONE);
registerBlockItem("cracked_dungeon_stone", CRACKED_DUNGEON_STONE);
registerBlockItem("reinforced_dungeon_bricks", REINFORCED_DUNGEON_BRICKS);
public static final DeferredBlock<Block> DUNGEON_PILLAR = BLOCKS.register(
    "dungeon_pillar", () -> new Block(BlockBehaviour.Properties.of()
        .strength(4.0F, 8.0F)
        .requiresCorrectToolForDrops()
        .sound(SoundType.STONE)));

public static final DeferredBlock<Block> DUNGEON_FLOOR = BLOCKS.register(
    "dungeon_floor", () -> new Block(BlockBehaviour.Properties.of()
        .strength(3.0F, 6.0F)
        .requiresCorrectToolForDrops()
        .sound(SoundType.DEEPSLATE)));

public static final DeferredBlock<Block> ANCIENT_LOCK = BLOCKS.register(
    "ancient_lock", () -> new Block(BlockBehaviour.Properties.of()
        .strength(-1.0F, 3600000.0F)
        .sound(SoundType.METAL)));
public static final DeferredBlock<Block> DUNGEON_SPAWNER = BLOCKS.register(
    "dungeon_spawner", () -> new Block(BlockBehaviour.Properties.of()
        .strength(5.0F, 12.0F)
        .requiresCorrectToolForDrops()
        .lightLevel(state -> 5)));

public static final DeferredBlock<Block> TRAP_PLATE = BLOCKS.register(
    "trap_plate", () -> new Block(BlockBehaviour.Properties.of()
        .strength(1.0F, 2.0F)
        .sound(SoundType.METAL)));

public static final DeferredBlock<Block> DUNGEON_CACHE = BLOCKS.register(
    "dungeon_cache", () -> new Block(BlockBehaviour.Properties.of()
        .strength(2.5F, 6.0F)
        .sound(SoundType.WOOD)));
registerBlockItem("dungeon_spawner", DUNGEON_SPAWNER);
registerBlockItem("trap_plate", TRAP_PLATE);
registerBlockItem("dungeon_cache", DUNGEON_CACHE);
public static final DeferredItem<Item> DUNGEON_SHARD =
    ITEMS.register("dungeon_shard", () -> new Item(new Item.Properties()));

public static final DeferredItem<Item> ANCIENT_FRAGMENT =
    ITEMS.register("ancient_fragment", () -> new Item(new Item.Properties()));

public static final DeferredItem<Item> CURSED_CRYSTAL =
    ITEMS.register("cursed_crystal", () -> new Item(new Item.Properties()));
public static final DeferredItem<Item> GUARDIAN_CORE =
    ITEMS.register("guardian_core", () -> new Item(new Item.Properties()));

public static final DeferredItem<Item> DUNGEON_ESSENCE =
    ITEMS.register("dungeon_essence", () -> new Item(new Item.Properties()));

public static final DeferredItem<Item> ANCIENT_INGOT =
    ITEMS.register("ancient_ingot", () -> new Item(new Item.Properties()));

public static final DeferredItem<Item> CRYPT_KEY =
    ITEMS.register("crypt_key", () -> new Item(new Item.Properties()));

public static final DeferredItem<Item> ANCIENT_KEY =
    ITEMS.register("ancient_key", () -> new Item(new Item.Properties()));

public static final DeferredItem<Item> DUNGEON_COMPASS =
    ITEMS.register("dungeon_compass", () -> new Item(new Item.Properties()));
public static final DeferredItem<Item> DUNGEON_TOKEN =
    ITEMS.register("dungeon_token", () -> new Item(new Item.Properties()));

public static final DeferredItem<Item> HEALING_ARTIFACT =
    ITEMS.register("healing_artifact", () -> new Item(new Item.Properties()));

public static final DeferredItem<Item> GUARDIANS_HEART =
    ITEMS.register("guardians_heart", () -> new Item(new Item.Properties()));
