
package pl.dorsz3000.dungeonoverhaul;

import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

@Mod("dungeon_overhaul")
public class DungeonOverhaul {

    public static final String MOD_ID = "dungeon_overhaul";

    public static final DeferredRegister.Blocks BLOCKS =
        DeferredRegister.createBlocks(MOD_ID);

    public static final DeferredRegister.Items ITEMS =
        DeferredRegister.createItems(MOD_ID);

    // BLOCKS 1-9

    public static final DeferredBlock<Block> DUNGEON_STONE =
        BLOCKS.register("dungeon_stone", () -> new Block(
            BlockBehaviour.Properties.of().strength(3.0F, 6.0F)
                .requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final DeferredBlock<Block> CRACKED_DUNGEON_STONE =
        BLOCKS.register("cracked_dungeon_stone", () -> new Block(
            BlockBehaviour.Properties.of().strength(2.5F, 6.0F)
                .requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final DeferredBlock<Block> REINFORCED_DUNGEON_BRICKS =
        BLOCKS.register("reinforced_dungeon_bricks", () -> new Block(
            BlockBehaviour.Properties.of().strength(-1.0F, 3600000.0F)
                .sound(SoundType.NETHERITE_BLOCK)));

    public static final DeferredBlock<Block> DUNGEON_PILLAR =
        BLOCKS.register("dungeon_pillar", () -> new Block(
            BlockBehaviour.Properties.of().strength(4.0F, 8.0F)
                .requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final DeferredBlock<Block> DUNGEON_FLOOR =
        BLOCKS.register("dungeon_floor", () -> new Block(
            BlockBehaviour.Properties.of().strength(3.0F, 6.0F)
                .requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));

    public static final DeferredBlock<Block> ANCIENT_LOCK =
        BLOCKS.register("ancient_lock", () -> new Block(
            BlockBehaviour.Properties.of().strength(-1.0F, 3600000.0F)
                .sound(SoundType.METAL)));

    public static final DeferredBlock<Block> DUNGEON_SPAWNER =
        BLOCKS.register("dungeon_spawner", () -> new Block(
            BlockBehaviour.Properties.of().strength(5.0F, 12.0F)
                .requiresCorrectToolForDrops().lightLevel(state -> 5)));

    public static final DeferredBlock<Block> TRAP_PLATE =
        BLOCKS.register("trap_plate", () -> new Block(
            BlockBehaviour.Properties.of().strength(1.0F, 2.0F)
                .sound(SoundType.METAL)));

    public static final DeferredBlock<Block> DUNGEON_CACHE =
        BLOCKS.register("dungeon_cache", () -> new Block(
            BlockBehaviour.Properties.of().strength(2.5F, 6.0F)
                .sound(SoundType.WOOD)));

    // ITEMS 1-12

    public static final DeferredItem<Item> DUNGEON_SHARD = item("dungeon_shard");
    public static final DeferredItem<Item> ANCIENT_FRAGMENT = item("ancient_fragment");
    public static final DeferredItem<Item> CURSED_CRYSTAL = item("cursed_crystal");
    public static final DeferredItem<Item> GUARDIAN_CORE = item("guardian_core");
    public static final DeferredItem<Item> DUNGEON_ESSENCE = item("dungeon_essence");
    public static final DeferredItem<Item> ANCIENT_INGOT = item("ancient_ingot");
    public static final DeferredItem<Item> CRYPT_KEY = item("crypt_key");
    public static final DeferredItem<Item> ANCIENT_KEY = item("ancient_key");
    public static final DeferredItem<Item> DUNGEON_COMPASS = item("dungeon_compass");
    public static final DeferredItem<Item> DUNGEON_TOKEN = item("dungeon_token");
    public static final DeferredItem<Item> HEALING_ARTIFACT = item("healing_artifact");
    public static final DeferredItem<Item> GUARDIANS_HEART = item("guardians_heart");

    private static DeferredItem<Item> item(String name) {
        return ITEMS.register(name, () -> new Item(new Item.Properties()));
    }

    private static void registerBlockItem(String name, DeferredBlock<Block> block) {
        ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public DungeonOverhaul(IEventBus modEventBus) {

        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);

        registerBlockItem("dungeon_stone", DUNGEON_STONE);
        registerBlockItem("cracked_dungeon_stone", CRACKED_DUNGEON_STONE);
        registerBlockItem("reinforced_dungeon_bricks", REINFORCED_DUNGEON_BRICKS);
        registerBlockItem("dungeon_pillar", DUNGEON_PILLAR);
        registerBlockItem("dungeon_floor", DUNGEON_FLOOR);
        registerBlockItem("ancient_lock", ANCIENT_LOCK);
        registerBlockItem("dungeon_spawner", DUNGEON_SPAWNER);
        registerBlockItem("trap_plate", TRAP_PLATE);
        registerBlockItem("dungeon_cache", DUNGEON_CACHE);

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
                                "Dungeon Overhaul: crypt, catacombs, nether_fortress, end_ruins"
                            ), false
                        );
                        return 1;
                    })
                )

                .then(Commands.literal("info")
                    .executes(context -> {
                        context.getSource().sendSuccess(
                            () -> Component.literal(
                                "Dungeon Overhaul Alpha 0.2 - 9 blocks and 12 items registered."
                            ), false
                        );
                        return 1;
                    })
                )

                .then(Commands.literal("spawn")
                    .then(Commands.literal("crypt")
                        .executes(context -> {
                            context.getSource().sendFailure(
                                Component.literal(
                                    "Crypt generation is not implemented yet."
                                )
                            );
                            return 0;
                        })
                    )
                )
        );
    }
}
